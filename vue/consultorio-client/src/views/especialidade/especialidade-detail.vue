<template>
    <div class="columns">
        <div class="column is-8 is-size-3">
            Especialidade: {{especialidade.nome}}
             <a href="/especialidade/listar" class="button is-8 is-warning">Voltar</a>
        </div>
    </div>
    
  <hr />

  <table class="table table is-fullwidth">
    <thead class="green">
      <tr style="background: hsl(141, 53%, 53%);">
        <th style="color: #fff;">ID</th>
        <th style="color: #fff;">Ativo</th>
        <th style="color: #fff;"></th>
        <th style="color: #fff;">Opções</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th>{{ especialidade.id }}</th>
        
        <th> 
          <span v-if="especialidade.ativo" class="tag is-success"> Ativo </span>
          <span v-if="!especialidade.ativo" class="tag is-danger"> Inativo </span>
        </th>
        <th></th>
        <th>
            <button @click="onClickDesativar(especialidade)" class="button is-small is-danger btn-inativar"> Inativar </button>
            <button @click="onClickEditar()" class="button is-small is-info"> Editar </button>
        </th>
      </tr>
    </tbody>
  </table>
</template>

<script lang="ts">
    import { Vue } from "vue-class-component";
    import { Especialidade } from '@/model/especialidade'
    import { Notification } from '@/model/notification'
    import { EspecialidadeClient } from '@/client/especialidade.client'
    import { Prop } from 'vue-property-decorator'


    export default class EspecialidadeDetalhar extends Vue {
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

        private onClickDesativar(): void {
          this.especialidade.ativo = false
          this.especialidadeClient.editar(this.especialidade)
          .then(
            success => {
              this.$router.push({name: 'especialidade-listar'})
            },
            error => console.log(error)
          )
        }

        private onClickEditar(): void {
          this.$router.push({ name: 'especialidade-editar', params: { id: this.especialidade.id} })
        }
        
    }
</script>
