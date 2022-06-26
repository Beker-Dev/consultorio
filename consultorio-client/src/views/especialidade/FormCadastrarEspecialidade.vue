<template>
  <div class="container">
    <h1 class="titulo" >Cadastrar Especialidade</h1>
    <div class="field">
      <label class="label">Nome</label>
      <div class="control">
        <input class="input" type="text" placeholder="nome">
      </div>
    </div>

    <div class="botoes-form">
      <router-link class="link-cad" to="/especialidade">
        <button class="button btn-voltar">Voltar</button>
      </router-link>
      <button class="button btn-salvar">Salvar</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "FormCadastrarEspecialidade"
}
</script>

<style lang="scss">
@import "~bulma/bulma.sass";
.container{
  margin-left: 30px;
  width: 80%;
}
.titulo{
  display: flex;
  justify-content: center;
  font-size: 30px;
}
.enums{
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  margin-block-end: 20px;
}
.botoes-form{
  display: flex;
  justify-content: space-between;
  flex-direction: row;
  width: 100%;
  margin-top: 20px;
  margin-block-end: 20px;
}
.btn-salvar{
  background-color: green;
  color: white;
  width: 40%;
}
.link-cad{
  width: 40%;
}
.btn-voltar{
  background-color: red;
  color: white;
  width: 100%;
}
</style>