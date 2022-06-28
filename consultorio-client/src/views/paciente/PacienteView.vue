<template>
  <div class="container">
    <h1 class="titulo" ><strong>Lista de Pacientes</strong></h1>
    <div class="control">
      <input class="input" type="busca-paciente" placeholder="Buscar Paciente">

      <router-link class="link-cad" to="/paciente/cadastrar">
        <button class="button btn-cadastrar">Cadastrar</button>
      </router-link>

    </div>
    <div class="table-pacientes">
      <table class="table">
        <thead>
        <tr>
          <th>Id</th>
          <th>Nome</th>
          <th>Tipo Atendimento</th>
          <th>N° Cartão Convênio</th>
          <th>Data Vencimento</th>
          <th>Convênio</th>
          <th>Celular</th>
          <th>Opções</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <th>1</th>
          <td>Teste</td>
          <td>Convênio</td>
          <td>001564648</td>
          <td>31/12/2022</td>
          <td>Unimed</td>
          <td>55 45 99901 - 4570</td>
          <td>
            <router-link to="/paciente/detalhar">
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
  name: "pacienteView"
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
.table-pacientes{
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