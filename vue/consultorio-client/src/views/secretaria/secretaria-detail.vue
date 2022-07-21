<template>
   <div class="columns">
        <div class="column is-8 is-size-3">
            Secretaria {{secretaria.nome}}
             <a href="/secretaria/listar" class="button is-8 is-warning">Voltar</a>
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
        <th style="color: #fff;">Salario</th>
        <th style="color: #fff;">Dt. Contratacao</th>
        <th style="color: #fff;">Pis</th>
        <th style="color: #fff;">Opções</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th>{{ secretaria.id }}</th>
        
        <th> 
          <span v-if="secretaria.ativo" class="tag is-success"> Ativo </span>
          <span v-if="!secretaria.ativo" class="tag is-danger"> Inativo </span>
        </th>
        <th>
            {{secretaria.telefone}}
        </th>
         <th>
            {{secretaria.celular}}
        </th>
        <th>
            {{secretaria.nacionalidade}}
        </th>
        <th>
            {{secretaria.cpf}}
        </th>
        <th>
            {{secretaria.rg}}
        </th>
         <th>
            {{secretaria.email}}
        </th>
        <th>
            {{secretaria.login}}
        </th>
        <th>
            {{secretaria.sexo}}
        </th>
         <th>
            R${{secretaria.salario}}
        </th>
        <th>
            {{secretaria.dataContratacao}}
        </th>
        <th>
            {{secretaria.pis}}
        </th>
        <th>
            <button @click="onClickDesativar(secretaria)" class="button is-small is-danger btn-inativar"> Inativar </button>
            <button @click="onClickEditar()" class="button is-small is-info"> Editar </button>
        </th>
      </tr>
    </tbody>
  </table>
</template>


<script lang="ts">
    import { Vue } from "vue-class-component";
    import { Secretaria } from '@/model/secretaria'
    import { Notification } from '@/model/notification'
    import { SecretariaClient } from '@/client/secretaria.client'
    import { Prop } from 'vue-property-decorator'

    export default class SecretariaDetalhar extends Vue {
        private secretariaClient!: SecretariaClient
        private secretaria : Secretaria = new Secretaria()
        private notification : Notification = new Notification()

        @Prop({ type: Number, required: false })
        private readonly id!: number

        public mounted(): void {
            this.secretariaClient = new SecretariaClient()
            this.getSecretariaById()
        }

        private getSecretariaById(): void {
            this.secretariaClient.findById(this.id)
            .then(
                success => {
                    this.secretaria.id = success.id
                    this.secretaria.nome = success.nome
                    this.secretaria.telefone = success.telefone
                    this.secretaria.celular = success.celular
                    this.secretaria.nacionalidade = success.nacionalidade
                    this.secretaria.cpf = success.cpf
                    this.secretaria.rg = success.rg
                    this.secretaria.email = success.email
                    this.secretaria.login = success.login
                    this.secretaria.senha = success.senha
                    this.secretaria.sexo = success.sexo
                    this.secretaria.salario = success.salario 
                    this.secretaria.dataContratacao = success.dataContratacao
                    this.secretaria.pis = success.pis
                    this.secretaria.ativo = success.ativo
                    this.secretaria.atualizado = success.atualizado
                    this.secretaria.cadastro = success.cadastro
                },
                error => console.log(error)
            )
        }

        private onClickDesativar(): void {
          this.secretaria.ativo = false
          this.secretariaClient.desativar(this.secretaria)
          .then(
            success => {
              this.$router.push({name: 'secretaria-listar'})
            },
            error => console.log(error)
          )
        }

        private onClickEditar(): void {
          this.$router.push({ name: 'secretaria-editar', params: { id: this.secretaria.id} })
        }
        
    }
</script>
