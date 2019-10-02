<template>
  <v-container >
         <v-row justify="center">
            <v-col cols="10">
              <v-data-table 
              :headers="headers"
              :items="items" 
              :items-per-page="10" 
              class="elevation-1">
              </v-data-table>
            </v-col>
          </v-row>
          <v-row justify="center">
          <v-btn 
            color="success" dark  @click="$router.push('/')">
            Back
          </v-btn>
          </v-row>
  </v-container>
</template>

<script>
import http from "../http-common"
 export default {
 name: "viewschudule",
    data ()  {
      return{ 
       headers: [
        { text: "Doctor Id", value: "doctorProfile.id" },
        { text: "ชื่อแพทย์", value: "doctorProfile.fname" },
        { text: "สกุล", value: "doctorProfile.lname" },
        { text: "ห้องตรวจ", value: "room.room" },
        { text: "วัน", value: "day.day" },
        { text: "เวลา", value: "periodTime.periodTime" },
      ],
      items: [] 
      };
      
      
    },
  
    methods:{
      /* eslint-disable no-console */
 

    getSchedules() {
      http
        .get("/schedule")
        .then(response => {
          this.items = response.data;
          console.log(this.items);
        })
        .catch(e => {
          console.log(e);
        });
     /* eslint-enable no-console */
    },
    },
       mounted(){
      
      this.getSchedules();
 
    }

  };

</script>
