<template>
  <v-app>
    <v-app-bar app class=" cyan darken-2">
      <v-toolbar-title class="headline text-uppercase" >
        <span>DOCTER INFORMATION SYSTEM</span>
     
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn
        text
        href="https://github.com/vuetifyjs/vuetify/releases/latest"
        target="_blank"
      >
       
      </v-btn>
    </v-app-bar>

    <v-content>
      <docter/>
    </v-content>
  </v-app>
</template>

<script>
import docter from './components/docter';

export default {
  name: 'App',
  components: {
    docter,
  },
  data: () => ({
    //
  }),
};
</script>
