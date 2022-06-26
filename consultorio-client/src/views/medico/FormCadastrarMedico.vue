<template>
  <div class="container">
    <h1 class="titulo" >Cadastrar Médico</h1>
    <div class="field">
      <label class="label">Nome</label>
      <div class="control">
        <input class="input" type="text" placeholder="nome">
      </div>
    </div>

    <div class="field">
      <label class="label">Telefone</label>
      <div class="control">
        <input class="input" type="number" placeholder="telefone">
      </div>
    </div>

    <div class="field">
      <label class="label">Celular</label>
      <div class="control">
        <input class="input" type="number" placeholder="celular">
      </div>
    </div>

    <div class="field">
      <label class="label">Nacionalidade</label>
      <div class="control">
        <input class="input" type="text" placeholder="nacionalidade">
      </div>
    </div>

    <div class="field">
      <label class="label">CPF</label>
      <div class="control">
        <input class="input" type="number" placeholder="cpf">
      </div>
    </div>

    <div class="field">
      <label class="label">RG</label>
      <div class="control">
        <input class="input" type="number" placeholder="rg">
      </div>
    </div>

    <div class="field">
      <label class="label">Email</label>
      <div class="control">
        <input class="input" type="email" placeholder="e-mail">
      </div>
    </div>

    <div class="field">
      <label class="label">Login</label>
      <div class="control">
        <input class="input" type="text" placeholder="login">
      </div>
    </div>

    <div class="field">
      <label class="label">Senha</label>
      <div class="control">
        <input class="input" type="password" placeholder="senha">
      </div>
    </div>

    <div class="enums">
      <div class="enum-sexo">
        <label class="label">Sexo</label>
        <div class="control">
          <div class="select">
            <select>
              <option>Masculino</option>
              <option>Feminino</option>
              <option>Outro</option>
            </select>
          </div>
        </div>
      </div>
    </div>

    <div class="field">
      <label class="label">CRM</label>
      <div class="control">
        <input class="input" type="number" placeholder="crm">
      </div>
    </div>

    <div class="field">
      <label class="label">Consultório</label>
      <div class="control">
        <input class="input" type="text" placeholder="consultorio">
      </div>
    </div>

    <div class="field">
      <label class="label">Porcentagem de Participação</label>
      <div class="control">
        <input class="input" type="number" placeholder="% de participação">
      </div>
    </div>

    <div class="field">
      <label class="label">Valor Consulta</label>
      <div class="control">
        <input class="input" type="number" placeholder="valor consulta">
      </div>
    </div>

    <div class="field">
      <label class="label">Especialidade</label>
      <div class="control">
        <input class="input" type="text" placeholder="especialidade">
      </div>
    </div>

    <div class="botoes-form">
      <router-link class="link-cad" to="/medico">
        <button class="button btn-voltar">Voltar</button>
      </router-link>
      <button class="button btn-salvar">Salvar</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "FormCadastrarMedico"
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