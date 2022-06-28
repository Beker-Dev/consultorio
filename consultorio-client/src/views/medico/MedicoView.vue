<template>
  <div class="container">
    <h1 class="titulo" ><strong>Lista de Médicos</strong></h1>
    <div class="control">
      <input class="input" type="busca-medico" placeholder="Buscar Médico">

      <router-link class="link-cad" to="/medico/cadastrar">
        <button class="button btn-cadastrar">Cadastrar</button>
      </router-link>

    </div>
    <div class="table-medicos">
      <table class="table">
        <thead>
        <tr>
          <th>Id</th>
          <th>Nome</th>
          <th>CRM</th>
          <th>Especialidade</th>
          <th>Participação</th>
          <th>Valor Consulta</th>
          <th>Celular</th>
          <th>Opções</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <th>1</th>
          <td>Joao</td>
          <td>04973/PR</td>
          <td>Neurologista</td>
          <td>20%</td>
          <td>R$450.00</td>
          <td>55 45 99901 - 4570</td>
          <td>
            <router-link to="/medico/detalhar">
              <button class="button is-info">Detalhar</button>
            </router-link>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name: "medicoView"
}
</script>

<style lang="scss">
@import "~bulma/bulma.sass";
.titulo{
  font-size: 30px;
  margin-top: 0px;
  margin-outside: 10px;
}
.input{
  width: 60%;
}
.table-medicos{
  margin-top: 60px;
}
.table{
  width: 91.4%;
  border-style: solid;
  border-color: darkgrey;
  border-width: 1px;
}
.link-cad{
  width: 30%;

}
.btn-cadastrar{
  width: 100%;
  height: 100%;
  margin-left: 20px;
  background-color: rgb(33, 120, 11);
  color: white;
  border-radius: 5px;
  border-width: 0px;
  font-size: 17px;
}
.control{
  display: flex;
  margin-top: 20px;
  width: 100%;
  flex-direction: row;
}
</style>