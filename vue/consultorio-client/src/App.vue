<template>
  
  <div class="columns">
    <div class="column is-12 menu-top">
        <strong>Consultório - Foz Health</strong>
    </div>
  </div>

  <div class="columns">
    <div class="column is-2">
      <nav>
        <aside class="menu">

          <p class="menu-label"> <router-link to="/">Home</router-link> </p>
          
          <p class="menu-label"> Agenda </p>
          <ul class="menu-list">
            <li><router-link to="/agenda/listar">Agendamento</router-link></li>
            <li><router-link to="/historico/listar">Históricos</router-link></li>
          </ul>
      
          <p class="menu-label"> Pessoas </p>
          <ul class="menu-list">
            <li><router-link to="/paciente/listar">Pacientes</router-link></li>
            <li><router-link to="/medico/listar">Médicos</router-link></li>
            <li><router-link to="/secretaria/listar">Secretárias</router-link></li>
          </ul>

          <p class="menu-label"> Administração </p>
          <ul class="menu-list">
            <li><router-link to="/especialidade/listar">Especialidade</router-link></li>
            <li><router-link to="/convenio/listar">Convênio</router-link></li>
          </ul>
        </aside>
      </nav>
    </div>
    <div class="column is-10 conteudo">
      <router-view> </router-view>
    </div>
  </div>
</template>

<style lang="scss">
  @import "~bulma/bulma.sass";

  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
  }

  nav {
    padding: 30px;

    a {
      font-weight: bold;
      color: #2c3e50;

      &.router-link-exact-active {
        color: #42b983;
      }
    }
  }

  .conteudo {
    //margin-top: 30px;
    padding-right: 30px;
  }

  .menu-top{
    background: hsl(211, 100%, 50%);
    padding: 30px;
    color: white;
  }
</style>
