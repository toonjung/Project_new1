<template>
  <v-app>
    <v-app-bar app class=" cyan darken-2">
      <v-toolbar-title class="headline text-uppercase" >
        <span>DOCTOR INFORMATION SYSTEM</span>
     
      </v-toolbar-title>
      <v-spacer></v-spacer>
      
    </v-app-bar>

    <v-content>
      <!--doctor/-->
      <router-view /> 
    </v-content>
  </v-app>
</template>

<script>

export default {
  name: 'App',
data: () => ({
    //
  }),
};
</script>
