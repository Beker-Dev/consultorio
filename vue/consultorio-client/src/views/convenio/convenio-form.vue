<template>
    
    <div class="columns">
        <div class="column is-12 is-size-3">
            Cadastrar Convenio
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
                <input v-model="convenio.ativo" checked type="checkbox">
                Ativar convenio
            </label>
        </div>
    </div>

    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Nome</label>
            <div class="control">
                <input class="input is-primary" type="text" v-model="convenio.nome" placeholder="Nome do Convenio">
            </div>
        </div>
    </div>
    <div class="columns">
        <div class="column is-12 is-size-3">
            <label class="label">Valor</label>
            <div class="control">
                <input class="input is-primary" type="number    " v-model="convenio.valor" placeholder="Valor do Convenio">
            </div>
        </div>
    </div>

     <hr />

    <div class="columns">
        <div class="column is-8"></div>
        <div class="column is-2">
            <a href="/convenio/listar" class="button is-fullwidth is-info">Voltar</a>
        </div>
        <div class="column is-2">
            <button class="button is-fullwidth is-success" @click="onClickCadastrar()">Salvar</button>
        </div>
    </div>

</template>

<script lang="ts">
    import { Vue } from 'vue-class-component';

    import { Convenio } from '@/model/convenio'
    import { Notification } from '@/model/notification'
    import { ConvenioClient } from '@/client/convenio.client'

    export default class ConvenioForm extends Vue {

        private convenioClient!: ConvenioClient
        private convenio : Convenio = new Convenio()
        private notification : Notification = new Notification()
    
        public mounted(): void {
            this.convenioClient = new ConvenioClient()
        }
        
        private onClickCadastrar(): void {

            this.convenioClient.cadastrar(this.convenio)
                .then(
                success => {
                    this.notification = this.notification.new(true, 'notification is-success', 'Convenio Cadastrada com sucesso!!!')
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
            this.convenio = new Convenio()
        }

        // private created(): void { }
    }
</script>