<template>
    <div class="columns">
        <div class="column is-8 is-size-3">
            convenio: {{convenio.nome}}
             <a href="/convenio/listar" class="button is-8 is-warning">Voltar</a>
        </div>
    </div>

    <hr/>

    <table class="table table is-fullwidth">
    <thead class="green">
      <tr style="background: hsl(141, 53%, 53%);">
        <th style="color: #fff;">ID</th>
        <th style="color: #fff;">Ativo</th>
        <th style="color: #fff;">Valor</th>
        <th style="color: #fff;">Opções</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th>{{ convenio.id }}</th>
        
        <th> 
          <span v-if="convenio.ativo" class="tag is-success"> Ativo </span>
          <span v-if="!convenio.ativo" class="tag is-danger"> Inativo </span>
        </th>
        <th>
            R${{convenio.valor}}
        </th>
        <th>
            <button @click="onClickDesativar(convenio)" class="button is-small is-danger btn-inativar"> Inativar </button>
            <button @click="onClickEditar()" class="button is-small is-info"> Editar </button>
        </th>
      </tr>
    </tbody>
  </table>

</template>

<script lang="ts">
    import { Vue } from "vue-class-component";
    import { Convenio } from '@/model/convenio'
    import { Notification } from '@/model/notification'
    import { ConvenioClient } from '@/client/convenio.client'
    import { Prop } from 'vue-property-decorator'

    export default class ConvenioDetalhar extends Vue {
        private convenioClient!: ConvenioClient
        private convenio : Convenio = new Convenio()
        private notification : Notification = new Notification()

        @Prop({type: Number, required: false })
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
                    this.convenio.nome = success.nome
                    this.convenio.ativo = success.ativo
                    this.convenio.valor = success.valor
                    this.convenio.atualizado = success.atualizado
                    this.convenio.cadastro = success.cadastro
                },
                error => console.log(error)
            )
        }

        private onClickDesativar(): void {
          this.convenio.ativo = false
          this.convenioClient.editar(this.convenio)
          .then(
            success => {
              this.$router.push({name: 'convenio-listar'})
            },
            error => console.log(error)
          )
        }

        private onClickEditar(): void {
          this.$router.push({ name: 'convenio-editar', params: { id: this.convenio.id} })
        }
    }
</script>
