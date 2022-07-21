<template>
   <div class="columns">
        <div class="column is-8 is-size-3">
            Medico: {{medico.nome}}
             <a href="/medico/listar" class="button is-8 is-warning">Voltar</a>
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
        <th style="color: #fff;">CRM</th>
        <th style="color: #fff;">Consultorio</th>
        <th style="color: #fff;">% Part</th>
        <th style="color: #fff;">Valor Consulta</th>
        <th style="color: #fff;">Espec</th>
        <th style="color: #fff;">Opções</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th>{{ medico.id }}</th>
        
        <th> 
          <span v-if="medico.ativo" class="tag is-success"> Ativo </span>
          <span v-if="!medico.ativo" class="tag is-danger"> Inativo </span>
        </th>
        <th>
            {{medico.telefone}}
        </th>
         <th>
            {{medico.celular}}
        </th>
        <th>
            {{medico.nacionalidade}}
        </th>
        <th>
            {{medico.cpf}}
        </th>
        <th>
            {{medico.rg}}
        </th>
         <th>
            {{medico.email}}
        </th>
        <th>
            {{medico.login}}
        </th>
        <th>
            {{medico.sexo}}
        </th>
         <th>
            {{medico.crm}}
        </th>
         <th>
            {{medico.consultorio}}
        </th>
         <th>
            {{medico.porcentagemParticipacao}}%
        </th>
        <th>
            R${{medico.valorConsulta}}
        </th>
        <th>
            <span v-if="medico.especialidade"> {{medico.especialidade.nome}} </span>
            <span v-if="!medico.especialidade" > --- </span>
        </th>
        <th>
            <button @click="onClickDesativar(medico)" class="button is-small is-danger btn-inativar"> Inativar </button>
            <button @click="onClickEditar()" class="button is-small is-info"> Editar </button>
        </th>
      </tr>
    </tbody>
  </table>
</template>


<script lang="ts">
    import { Vue } from "vue-class-component";
    import { Medico } from '@/model/medico'
    import { Notification } from '@/model/notification'
    import { MedicoClient } from '@/client/medico.client'
    import { Prop } from 'vue-property-decorator'

    export default class MedicoDetalhar extends Vue {
        private medicoClient!: MedicoClient
        private medico : Medico = new Medico()
        private notification : Notification = new Notification()

        @Prop({ type: Number, required: false })
        private readonly id!: number

        public mounted(): void {
            this.medicoClient = new MedicoClient()
            this.getMedicoById()
        }

        private getMedicoById(): void {
            this.medicoClient.findById(this.id)
            .then(
                success => {
                    this.medico.id = success.id
                    this.medico.nome = success.nome
                    this.medico.telefone = success.telefone
                    this.medico.celular = success.celular
                    this.medico.nacionalidade = success.nacionalidade
                    this.medico.cpf = success.cpf
                    this.medico.rg = success.rg
                    this.medico.email = success.email
                    this.medico.login = success.login
                    this.medico.senha = success.senha
                    this.medico.sexo = success.sexo
                    this.medico.crm = success.crm
                    this.medico.consultorio = success.consultorio
                    this.medico.porcentagemParticipacao = success.porcentagemParticipacao
                    this.medico.valorConsulta = success.valorConsulta
                    this.medico.especialidade = success.especialidade
                    this.medico.ativo = success.ativo
                    this.medico.atualizado = success.atualizado
                    this.medico.cadastro = success.cadastro
                },
                error => console.log(error)
            )
        }

        private onClickDesativar(): void {
          this.medico.ativo = false
          this.medicoClient.desativar(this.medico)
          .then(
            success => {
              this.$router.push({name: 'medico-listar'})
            },
            error => console.log(error)
          )
        }

        private onClickEditar(): void {
          this.$router.push({ name: 'medico-editar', params: { id: this.medico.id} })
        }
        
    }
</script>
