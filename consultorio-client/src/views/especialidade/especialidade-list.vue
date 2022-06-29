<template>
    
  <div class="columns">
    <div class="column is-12 is-size-3">
      Lista de Especialidades
    </div>
  </div>
    
  <hr />

  <div class="columns">
    <div class="column is-9">
      <input class="input" type="filtro" placeholder="Nome da Especialidade">            
    </div>
    <div class="column is-3">
      <a :href="'/especialidade/cadastrar'" class="button is-info is-fullwidth">Cadastrar</a>
    </div>
  </div>

  <hr />

  <table class="table table is-fullwidth">
    <thead class="green">
      <tr style="background: hsl(141, 53%, 53%);">
        <th style="color: #fff;">ID</th>
        <th style="color: #fff;">Ativo</th>
        <th style="color: #fff;">Especialidade</th>
        <th style="color: #fff;">Opções</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="item in especialidadeList" :key="item.id">
        <th>{{ item.id }}</th>
        
        <th> 
          <span v-if="item.ativo" class="tag is-success"> Ativo </span>
          <span v-if="!item.ativo" class="tag is-danger"> Inativo </span>
        </th>
        
        <th>{{ item.nome }}</th>
        <th> <button class="button is-small is-warning"> Detalhar </button> </th>
      </tr>
    </tbody>
  </table>

</template>

<script lang="ts">
  import { Vue } from 'vue-class-component';
  
  import { PageRequest } from '@/model/page/page-request'
  import { PageResponse } from '@/model/page/page-response'
  
  import { Especialidade } from '@/model/especialidade'
  import { EspecialidadeClient } from '@/client/especialidade.client'
  

  export default class EspecialidadeList extends Vue {

    private pageRequest: PageRequest = new PageRequest()
    private pageResponse: PageResponse<Especialidade> = new PageResponse()

    private especialidadeList: Especialidade[] = []
    private especialidadeClient!: EspecialidadeClient

    public mounted(): void {
      this.especialidadeClient = new EspecialidadeClient()
      this.listarEspecialidade()
    }

    private listarEspecialidade(): void {
      this.especialidadeClient.findByFiltrosPaginado(this.pageRequest)
        .then(
          success => {
            this.pageResponse = success
            this.especialidadeList = this.pageResponse.content
          },
          error => console.log(error)
        )
    }
  }
</script>