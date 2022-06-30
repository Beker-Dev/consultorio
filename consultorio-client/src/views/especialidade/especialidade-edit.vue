<template>
    
    <div class="columns">
        <div class="column is-12 is-size-3">
            Editar Especialidade: {{especialidade.nome}}
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
                <input class="input is-primary" type="text" v-model="especialidade.nome" placeholder="{{especialidade.nome}}">
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
    import { Especialidade } from '@/model/especialidade'
    import { Notification } from '@/model/notification'
    import { EspecialidadeClient } from '@/client/especialidade.client'

    export default class EspecialidadeEditar extends Vue {

        private especialidadeClient!: EspecialidadeClient
        private especialidade : Especialidade = new Especialidade()
        private notification : Notification = new Notification()

        @Prop({ type: Number, required: false })
        private readonly id!: number
    
        public mounted(): void {
            this.especialidadeClient = new EspecialidadeClient()
            this.getEspecialidadeById()

        }
        
       private getEspecialidadeById(): void {
            this.especialidadeClient.findById(this.id)
            .then(
                success => {
                    this.especialidade.id = success.id
                    this.especialidade.ativo = success.ativo
                    this.especialidade.atualizado = success.atualizado
                    this.especialidade.cadastro = success.cadastro
                    this.especialidade.nome = success.nome
                },
                error => console.log(error)
            )
       }

        private onClickFecharNotificacao(): void {
            this.notification = new Notification()
        }

        private onClickLimpar(): void {
            this.especialidade = new Especialidade()
        }

        private onClickEditar(): void {
            this.especialidadeClient.editar(this.especialidade)
            .then(
                success => {
                    this.notification = this.notification.new(true, 'notification is-success', 'Especialidade Editada com sucesso!!!')
                }, error => {
                    this.notification = this.notification.new(true, 'notification is-danger', 'Error: ' + error)
                })
        }

        private onClickVoltar(): void {
          this.$router.push({ name: 'especialidade-detalhar', params: { id: this.especialidade.id} })
        }
    }
</script>