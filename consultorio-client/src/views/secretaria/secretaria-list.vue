<template>
    
  <div class="columns">
    <div class="column is-12 is-size-3">
      Lista de Secretarias
    </div>
  </div>
    
  <hr />

  <div class="columns">
    <div class="column is-9">
      <input class="input" type="filtro" placeholder="Nome da Secretaria">            
    </div>
    <div class="column is-3">
      <a :href="'/secretaria/cadastrar'" class="button is-info is-fullwidth">Cadastrar</a>
    </div>
  </div>

  <hr />

  <table class="table table is-fullwidth">
    <thead class="green">
      <tr style="background: hsl(141, 53%, 53%);">
        <th style="color: #fff;">ID</th>
        <th style="color: #fff;">Ativo</th>
        <th style="color: #fff;">Secretaria</th>
        <th style="color: #fff;">Opções</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="item in secretariaList" :key="item.id">
        <th>{{ item.id }}</th>
        
        <th> 
          <span v-if="item.ativo" class="tag is-success"> Ativo </span>
          <span v-if="!item.ativo" class="tag is-danger"> Inativo </span>
        </th>
        
        <th>{{ item.nome }}</th>
        <th> <button @click="onClickPaginaDetalhar(item.id)" class="button is-small is-warning"> Detalhar </button> </th>
      </tr>
    </tbody>
  </table>

</template>

<script lang="ts">
  import { Vue } from 'vue-class-component';
  
  import { PageRequest } from '@/model/page/page-request'
  import { PageResponse } from '@/model/page/page-response'
  
  import { Secretaria } from '@/model/secretaria'
  import { SecretariaClient } from '@/client/secretaria.client'
  

  export default class SecretariaList extends Vue {

    private pageRequest: PageRequest = new PageRequest()
    private pageResponse: PageResponse<Secretaria> = new PageResponse()

    private secretariaList: Secretaria[] = []
    private secretariaClient!: SecretariaClient

    public mounted(): void {
      this.secretariaClient = new SecretariaClient()
      this.listarSecretaria()
    }

    private listarSecretaria(): void {
      this.secretariaClient.findByFiltrosPaginado(this.pageRequest)
        .then(
          success => {
            this.pageResponse = success
            this.secretariaList = this.pageResponse.content
          },
          error => console.log(error)
        )
    }

    private onClickPaginaDetalhar(idMedico: number){
      this.$router.push({ name: 'secretaria-detalhar', params: { id: idMedico} })
    }
  }
</script>