<template>
  <v-container class="grey lighten-5">
    <v-row  >
      <v-col md="3"  align = "start"  >
        
        <v-row>
          <v-text-field 
            v-model="schedule.doctorProfileId" 
            label="DOCTOR ID" 
            :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']" 
            required > 
          </v-text-field>
          
          <v-btn 
            class="ma-6" 
            small color="primary" 
            dark
            @click="findDoctorProfile"
            >
            Search
          </v-btn>
          </v-row>
          <br>

          <v-row>
          <div v-if="doctorFound == true">
             DOCTOR NAME :
              {{doctorFname}} 
              {{doctorLname}}
          </div>
          </v-row>
        
        <v-select 
          v-model="schedule.roomId"  
          :items="rooms"
          item-text="room"
          item-value="id"  
          label="โปรดเลือกห้องตรวจ" 
          :rules = "[(v) => !!v || 'กรุณากรอกข้อมูล']"
          required >
        </v-select>
        <v-select 
          v-model="schedule.dayId" 
          :items="days"
          item-text="day"
          item-value="id"  
          label="โปรดเลือกวัน"
          :rules = "[(v) => !!v || 'กรุณากรอกข้อมูล']"
          required >
        </v-select>
        <v-select 
          v-model="schedule.periodTimeId" 
          :items="periodTimes" 
          item-text="periodTime" 
          item-value="id"  
          label="โปรดเลือกเวลา"
          :rules = "[(v) => !!v || 'กรุณากรอกข้อมูล']"
          required >
        </v-select> 
        <v-row justify="center">  
          <v-btn 
            class="mr-4" 
            color="primary"
             @click="saveSchedule" 
             >
            ADD
          </v-btn>
          <v-btn 
            color="error">
            REMOVE
          </v-btn>
        </v-row >
        </v-col>
        <v-col align = "center">
          
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import http from "../http-common"

  export default {
    name:"schedule",
    data ()  {
      return{ 
        schedule: {
          doctorProfileId:"",
          roomId:"",
          dayId:"",
          periodTimeId:"", //คลาสที่เอามาเก็บตัวแxร
          
        },
     
      valid: false,
      doctorProfileCheck: false,
      doctorFound:false,
      doctorFname:"",
      doctorLname:"",
      rooms:[],
      days:[],
      periodTimes:[],
         
      };
      
    },
  

    methods:{
      /* eslint-disable no-console */
        // ดึงข้อมูล Room ใส่ combobox
    getRooms() {
      http
        .get("/room")
        .then(response => {
          this.rooms = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล Day ใส่ combobox
    getDays() {
      http
        .get("/day")
        .then(response => {
          this.days = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล Room ใส่ combobox
    getPeriodTimes() {
      http
        .get("/PeriodTime")
        .then(response => {
          this.periodTimes = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
        /* eslint-disable */
    }, findDoctorProfile() {
      http
        .get("/doctorProfile/" + this.schedule.doctorProfileId)
        .then(response => {
          console.log(response);
          if (response.data != null) {
            this.doctorFname = response.data.fname;
            this.doctorLname = response.data.lname;
            console.log(this.doctorFname);
            console.log(this.doctorLname);
            this.doctorProfileCheck = response.status;
            this.doctorFound = true;
          } else {
            this.clear()
            this.doctorFound = false;
           // this.employeeNotFound = true;
          }          
        })
        .catch(e => {
          console.log(e);
        });
      this.submitted = true;
    },
    // function เมื่อกดปุ่ม submit
    saveSchedule() {
      http
        .post(
          "/schedule/" + this.schedule.doctorProfileId +
           "/" +
            this.schedule.roomId +
            "/" +
            this.schedule.dayId +
            "/" +
            this.schedule.periodTimeId,
          this.schedule
        )
        .then(response => {
          console.log(response);
          this.$router.push("/view");
        })
        .catch(e => {
          console.log(e);
        });
      this.submitted = true;
    },
    clear() {
      this.$refs.form.reset();
      this.doctorProfileCheck = false;
      this.doctorFound = false;
     // this.employeeNotFound = true;
    },
  

     /* eslint-enable no-console */
    },
    mounted(){
     this.getRooms ();
      this.getDays();
      this.getPeriodTimes();
 
    }
  
  };
</script>