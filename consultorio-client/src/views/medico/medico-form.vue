<template>
    
    <div class="columns">
        <div class="column is-12 is-size-3">
            Cadastrar Medico
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
                <input v-model="medico.ativo" checked type="checkbox">
                Ativar Medico
            </label>
        </div>
    </div>

    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Nome</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="medico.nome" placeholder="Nome do Medico">
            </div>
        </div>
    </div>

     <hr />

    <div class="columns">
        <div class="column is-8"></div>
        <div class="column is-2">
            <a href="/medico/listar" class="button is-fullwidth is-info">Voltar</a>
        </div>
        <div class="column is-2">
            <button class="button is-fullwidth is-success" @click="onClickCadastrar()">Success</button>
        </div>
    </div>

</template>

<script lang="ts">
    import { Vue } from 'vue-class-component';

    import { Medico } from '@/model/medico'
    import { Notification } from '@/model/notification'
    import { MedicoClient } from '@/client/medico.client'

    export default class MedicoForm extends Vue {

        private medicoClient!: MedicoClient
        private medico : Medico = new Medico()
        private notification : Notification = new Notification()
    
        public mounted(): void {
            this.medicoClient = new MedicoClient()
        }
        
        private onClickCadastrar(): void {

            this.medicoClient.cadastrar(this.medico)
                .then(
                success => {
                    this.notification = this.notification.new(true, 'notification is-success', 'Medico Cadastrado com sucesso!!!')
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
            this.medico = new Medico()
        }

        // private created(): void { }
    }
</script>