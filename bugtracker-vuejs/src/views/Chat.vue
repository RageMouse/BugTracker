<template>
  <div class="home">
    <WebsocketGreetings msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import WebsocketGreetings from '@/components/WebsocketGreetings.vue'

export default {
  name: 'Home',
  components: {
    WebsocketGreetings
  }
}
</script>
