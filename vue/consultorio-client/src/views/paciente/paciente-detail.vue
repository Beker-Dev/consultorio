<template>
   <div class="columns">
        <div class="column is-8 is-size-3">
            Paciente: {{paciente.nome}}
             <a href="/paciente/listar" class="button is-8 is-warning">Voltar</a>
        </div>
    </div>
    
  <hr />

  <table class="table table is-fullwidth">
    <thead class="green">
      <tr style="background: hsl(141, 53%, 53%);">
        <th style="color: #fff;">ID</th>
        <th style="color: #fff;">Ativo</th>
        <th style="color: #fff;">Tel</th>
        <th style="color: #fff;">Cel</th>
        <th style="color: #fff;">Nacionalidade</th>
        <th style="color: #fff;">CPF</th>
        <th style="color: #fff;">RG</th>
        <th style="color: #fff;">Email</th>
        <th style="color: #fff;">Login</th>
        <th style="color: #fff;">Sexo</th>
        <th style="color: #fff;">Atendimento</th>
        <th style="color: #fff;">C. Convenio</th>
        <th style="color: #fff;">Dt. Venc</th>
        <th style="color: #fff;">Convenio</th>
        <th style="color: #fff;">Opções</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th>{{ paciente.id }}</th>
        
        <th> 
          <span v-if="paciente.ativo" class="tag is-success"> Ativo </span>
          <span v-if="!paciente.ativo" class="tag is-danger"> Inativo </span>
        </th>
        <th>
            {{paciente.telefone}}
        </th>
         <th>
            {{paciente.celular}}
        </th>
        <th>
            {{paciente.nacionalidade}}
        </th>
        <th>
            {{paciente.cpf}}
        </th>
        <th>
            {{paciente.rg}}
        </th>
         <th>
            {{paciente.email}}
        </th>
        <th>
            {{paciente.login}}
        </th>
        <th>
            {{paciente.sexo}}
        </th>
         <th>
            {{paciente.tipoAtendimento}}
        </th>
         <th>
             <span v-if="paciente.numeroCartaoConvenio"> {{paciente.numeroCartaoConvenio}} </span>
            <span v-if="!paciente.numeroCartaoConvenio" > --- </span>
        </th>
         <th>
             <span v-if="paciente.dataVencimento"> {{paciente.dataVencimento}} </span>
            <span v-if="!paciente.dataVencimento" > --- </span>
        </th>
        <th>
            <span v-if="paciente.convenio"> {{paciente.convenio.nome}} </span>
            <span v-if="!paciente.convenio" > --- </span>
        </th>
        <th>
            <button @click="onClickDesativar(paciente)" class="button is-small is-danger btn-inativar"> Inativar </button>
            <button @click="onClickEditar()" class="button is-small is-info"> Editar </button>
        </th>
      </tr>
    </tbody>
  </table>
</template>


<script lang="ts">
    import { Vue } from "vue-class-component";
    import { Paciente } from '@/model/paciente'
    import { Notification } from '@/model/notification'
    import { PacienteClient } from '@/client/paciente.client'
    import { Prop } from 'vue-property-decorator'

    export default class PacienteDetalhar extends Vue {
        private pacienteClient!: PacienteClient
        private paciente : Paciente = new Paciente()
        private notification : Notification = new Notification()

        @Prop({ type: Number, required: false })
        private readonly id!: number

        public mounted(): void {
            this.pacienteClient = new PacienteClient()
            this.getPacienteById()
        }

        private getPacienteById(): void {
            this.pacienteClient.findById(this.id)
            .then(
                success => {
                    this.paciente.id = success.id
                    this.paciente.nome = success.nome
                    this.paciente.telefone = success.telefone
                    this.paciente.celular = success.celular
                    this.paciente.nacionalidade = success.nacionalidade
                    this.paciente.cpf = success.cpf
                    this.paciente.rg = success.rg
                    this.paciente.email = success.email
                    this.paciente.login = success.login
                    this.paciente.senha = success.senha
                    this.paciente.sexo = success.sexo
                    this.paciente.tipoAtendimento = success.tipoAtendimento
                    this.paciente.numeroCartaoConvenio = success.numeroCartaoConvenio
                    this.paciente.dataVencimento = success.dataVencimento
                    this.paciente.convenio = success.convenio
                    this.paciente.ativo = success.ativo
                    this.paciente.atualizado = success.atualizado
                    this.paciente.cadastro = success.cadastro
                },
                error => console.log(error)
            )
        }

        private onClickDesativar(): void {
          this.paciente.ativo = false
          this.pacienteClient.desativar(this.paciente)
          .then(
            success => {
              this.$router.push({name: 'paciente-listar'})
            },
            error => console.log(error)
          )
        }

        private onClickEditar(): void {
          this.$router.push({ name: 'paciente-editar', params: { id: this.paciente.id} })
        }
        
    }
</script>
