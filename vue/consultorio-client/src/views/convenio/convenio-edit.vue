<template>
    <div class="columns">
        <div class="column is-12 is-size-3">
            Editar Convenio: {{convenio.nome}}
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
                Ativar Convenio
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
            <a @click="onClickVoltar()" class="button is-fullwidth is-info">Voltar</a>
        </div>
        <div class="column is-2">
            <button class="button is-fullwidth is-success" @click="onClickEditar()">Salvar</button>
        </div>
    </div>


</template>

<script lang="ts">

    import { Vue } from 'vue-class-component';
    import { Prop } from 'vue-property-decorator'
    import { Convenio } from '@/model/convenio'
    import { Notification } from '@/model/notification'
    import { ConvenioClient } from '@/client/convenio.client'

    export default class ConvenioEditar extends Vue {
        private convenioClient!: ConvenioClient
        private convenio : Convenio = new Convenio()
        private notification : Notification = new Notification()

        @Prop({ type: Number, required: false })
        private readonly id!: number
    
        public mounted(): void {
            this.convenioClient = new ConvenioClient()
            this.getConvenioById()

        }
        
       private getConvenioById(): void {
            this.convenioClient.findById(this.id)
            .then(
                success => {
                    this.convenio.id = success.id
                    this.convenio.ativo = success.ativo
                    this.convenio.atualizado = success.atualizado
                    this.convenio.cadastro = success.cadastro
                    this.convenio.nome = success.nome
                    this.convenio.valor = success.valor
                },
                error => console.log(error)
            )
       }

       private onClickFecharNotificacao(): void {
            this.notification = new Notification()
        }

        private onClickLimpar(): void {
            this.convenio = new Convenio()
        }

        private onClickEditar(): void {
            this.convenioClient.editar(this.convenio)
            .then(
                success => {
                    this.notification = this.notification.new(true, 'notification is-success', 'Convenio Editado com sucesso!!!')
                }, error => {
                    this.notification = this.notification.new(true, 'notification is-danger', 'Error: ' + error)
                })
        }

        private onClickVoltar(): void {
          this.$router.push({ name: 'convenio-detalhar', params: { id: this.convenio.id} })
        }
    }

</script>