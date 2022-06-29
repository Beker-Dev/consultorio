<template>
    
    <div class="columns">
        <div class="column is-12 is-size-3">
            Cadastrar Especialidade
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
                <input v-model="especialidade.ativo" checked type="checkbox">
                Ativar Especialidade
            </label>
        </div>
    </div>

    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Nome</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="especialidade.nome" placeholder="Nome da Especialidade">
            </div>
        </div>
    </div>

     <hr />

    <div class="columns">
        <div class="column is-8"></div>
        <div class="column is-2">
            <a href="/especialidade/listar" class="button is-fullwidth is-info">Voltar</a>
        </div>
        <div class="column is-2">
            <button class="button is-fullwidth is-success" @click="onClickCadastrar()">Success</button>
        </div>
    </div>

</template>

<script lang="ts">
    import { Vue } from 'vue-class-component';

    import { Especialidade } from '@/model/especialidade'
    import { Notification } from '@/model/notification'
    import { EspecialidadeClient } from '@/client/especialidade.client'

    export default class EspecialidadeForm extends Vue {

        private especialidadeClient!: EspecialidadeClient
        private especialidade : Especialidade = new Especialidade()
        private notification : Notification = new Notification()
    
        public mounted(): void {
            this.especialidadeClient = new EspecialidadeClient()
        }
        
        private onClickCadastrar(): void {

            this.especialidadeClient.cadastrar(this.especialidade)
                .then(
                success => {
                    this.notification = this.notification.new(true, 'notification is-success', 'Especialidade Cadastrada com sucesso!!!')
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
            this.especialidade = new Especialidade()
        }

        // private created(): void { }
    }
</script>