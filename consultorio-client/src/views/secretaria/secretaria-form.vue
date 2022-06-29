<template>
    
    <div class="columns">
        <div class="column is-12 is-size-3">
            Cadastrar Secretaria
        </div>
    </div>

    <hr />

    <div class="columns" v-if="notification.ativo">
        <div class="column is-12">
            <div :class="notification.classe">
                <button @click="onClickFecharNotificacao()" class="delete" ></button>
                {{ notification.mensagem }}
            </div>
        </div>
    </div>

    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">
                <input v-model="secretaria.ativo" checked type="checkbox">
                Ativar Secretaria
            </label>
        </div>
    </div>

    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Nome</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="secretaria.nome" placeholder="Nome da Secretaria">
            </div>
        </div>
    </div>

     <hr />

    <div class="columns">
        <div class="column is-8"></div>
        <div class="column is-2">
            <a href="/secretaria/listar" class="button is-fullwidth is-info">Voltar</a>
        </div>
        <div class="column is-2">
            <button class="button is-fullwidth is-success" @click="onClickCadastrar()">Success</button>
        </div>
    </div>

</template>

<script lang="ts">
    import { Vue } from 'vue-class-component';

    import { Secretaria } from '@/model/secretaria'
    import { Notification } from '@/model/notification'
    import { SecretariaClient } from '@/client/secretaria.client'

    export default class SecretariaForm extends Vue {

        private secretariaClient!: SecretariaClient
        private secretaria : Secretaria = new Secretaria()
        private notification : Notification = new Notification()
    
        public mounted(): void {
            this.secretariaClient = new SecretariaClient()
        }
        
        private onClickCadastrar(): void {

            this.secretariaClient.cadastrar(this.secretaria)
                .then(
                success => {
                    this.notification = this.notification.new(true, 'notification is-success', 'Secretaria Cadastrada com sucesso!!!')
                    this.onClickLimpar()
                }, error => {
                    this.notification = this.notification.new(true, 'notification is-danger', 'Error: ' + error)
                    this.onClickLimpar()
                })
        }

        private onClickFecharNotificacao(): void {
            this.notification = new Notification()
        }

        private onClickLimpar(): void {
            this.secretaria = new Secretaria()
        }

        // private created(): void { }
    }
</script>