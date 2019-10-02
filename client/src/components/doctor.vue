<template>
  <v-container >
    <div v-if="doctorProfileNotFound">
      <v-alert dense outlined type="error">
        <strong>ไม่พบข้อมูลผู้ป่วย</strong> กรุณากรอกข้อมูลอีกครั้ง
      </v-alert>
    </div>

    <div v-if="saveUSC">
      <v-alert outlined dense text type="warning" prominent border="left">
        <strong>ไม่สามารถบันทึกได้</strong> โปรดตรวจสอบข้อมูลอีกครั้ง
      </v-alert>
    </div>

    <div v-if="saveSC">
      <v-alert dense outlined text prominent type="success">บันทึกข้อมูลสำเร็จ</v-alert>
    </div>

    <div >
      <v-row justify="center" >
        <v-col md="5"  >
            <v-row>
              <v-text-field 
                v-model="schedule.doctorProfileId" 
                label="DOCTOR ID" 
                :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']" 
                required > 
              </v-text-field>
              <v-btn 
                class="ma-2" 
                small color="primary" dark
                @click="findDoctorProfile"
                >
                Search
              </v-btn>
            </v-row>
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
                color="success" dark  
                @click="$router.push('viewschudule')"
                >
                ตารางงานแพทย์
              </v-btn>
            </v-row >
        </v-col>   
      </v-row>
    </div>
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
        doctorFound:false,
        doctorProfileNotFound:false,
        saveSC:false,
        saveUSC:false,
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
      }, 
      
      // ค้นหา id doctor
      findDoctorProfile() {
      http
        .get("/doctorProfile/" + this.schedule.doctorProfileId)
        .then(response => {
          console.log(response);
          if (response.data != null) {
            this.doctorFname = response.data.fname;
            this.doctorLname = response.data.lname;
            console.log(this.doctorFname);
            console.log(this.doctorLname);
            this.doctorFound = true;
            this.doctorProfileNotFound = false;
          } else {
            this.clear()
            this.doctorFound = false;
            this.doctorProfileNotFound = true;  
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
          
          this.saveUSC = false;
          this.saveSC = true;
        })
        
        .catch(e => {
          console.log(e);
          this.saveUSC = true;
          this.saveSC = false;
        });
      this.submitted = true;
    },
    clear() {
      this.$refs.form.reset();
      this.doctorFound = false;
     
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