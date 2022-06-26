<template>
  <div class="container">
    <h1 class="titulo" >Lista de Convênios</h1>
    <div class="control">
      <input class="input" type="nome-convenios" placeholder="Buscar Convênios">

      <router-link class="link-cad" to="/convenio/cadastrar">
        <button class="button btn-cadastrar">Cadastrar</button>
      </router-link>

    </div>
    <div class="table-convenios">
      <table class="table">
        <thead>
        <tr>
          <th>Id</th>
          <th>Nome</th>
          <th>Valor</th>
          <th>Opções</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <th>1</th>
          <td>Unimed</td>
          <td>R$150.00</td>
          <td>
            <router-link to="/convenio/detalhar">
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
  name: "convenioView"
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
.table-convenios{
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
  background-color: green;
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