<template>
    
    <div class="columns">
        <div class="column is-12 is-size-3">
            Cadastrar Paciente
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
                <input v-model="paciente.ativo" checked type="checkbox">
                Ativar Paciente
            </label>
        </div>
    </div>

    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Nome</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="paciente.nome" placeholder="Nome da paciente">
            </div>
        </div>
    </div>

     <hr />

    <div class="columns">
        <div class="column is-8"></div>
        <div class="column is-2">
            <a href="/paciente/listar" class="button is-fullwidth is-info">Voltar</a>
        </div>
        <div class="column is-2">
            <button class="button is-fullwidth is-success" @click="onClickCadastrar()">Success</button>
        </div>
    </div>

</template>

<script lang="ts">
    import { Vue } from 'vue-class-component';

    import { Paciente } from '@/model/paciente'
    import { Notification } from '@/model/notification'
    import { PacienteClient } from '@/client/paciente.client'

    export default class PacienteForm extends Vue {

        private pacienteClient!: PacienteClient
        private paciente : Paciente = new Paciente()
        private notification : Notification = new Notification()
    
        public mounted(): void {
            this.pacienteClient = new PacienteClient()
        }
        
        private onClickCadastrar(): void {

            this.pacienteClient.cadastrar(this.paciente)
                .then(
                success => {
                    this.notification = this.notification.new(true, 'notification is-success', 'Paciente Cadastrada com sucesso!!!')
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
            this.paciente = new Paciente()
        }

        // private created(): void { }
    }
</script>