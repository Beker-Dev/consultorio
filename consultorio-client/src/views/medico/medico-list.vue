<template>
    
  <div class="columns">
    <div class="column is-12 is-size-3">
      Lista de Medicos
    </div>
  </div>
    
  <hr />

  <div class="columns">
    <div class="column is-9">
      <input class="input" type="filtro" placeholder="Nome do Medico">            
    </div>
    <div class="column is-3">
      <a :href="'/medico/cadastrar'" class="button is-info is-fullwidth">Cadastrar</a>
    </div>
  </div>

  <hr />

  <table class="table table is-fullwidth">
    <thead class="green">
      <tr style="background: hsl(141, 53%, 53%);">
        <th style="color: #fff;">ID</th>
        <th style="color: #fff;">Ativo</th>
        <th style="color: #fff;">Medico</th>
        <th style="color: #fff;">Opções</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="item in medicoList" :key="item.id">
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
  
  import { Medico } from '@/model/medico'
  import { MedicoClient } from '@/client/medico.client'
  

  export default class MedicoList extends Vue {

    private pageRequest: PageRequest = new PageRequest()
    private pageResponse: PageResponse<Medico> = new PageResponse()

    private medicoList: Medico[] = []
    private medicoClient!: MedicoClient

    public mounted(): void {
      this.medicoClient = new MedicoClient()
      this.listarMedico()
    }

    private listarMedico(): void {
      this.medicoClient.findByFiltrosPaginado(this.pageRequest)
        .then(
          success => {
            this.pageResponse = success
            this.medicoList = this.pageResponse.content
          },
          error => console.log(error)
        )
    }
  }
</script>