<template>
  <v-container class="grey lighten-5">
    <v-row  >
      <v-col md="3"  align = "start"  >
        
        <v-row>
          <v-text-field 
            v-model="schedule.employee" 
            label="DOCTOR ID" 
            :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']" 
            required > 
          </v-text-field>
          <p v-if="employeeCheck != ''">Docter Name : {{employeeName}}</p>
          <v-btn 
            class="ma-6" 
            small color="primary" 
            dark 
            @click="findEmployee,getRooms(),getDays(),getDuraions()">
            Search
          </v-btn>
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
          v-model="schedule.durationId" 
          :items="durations" 
          item-text="duration" 
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
             :class="{ red: !valid, green: valid }">
            ADD
          </v-btn>
          <v-btn 
            color="error">
            REMOVE
          </v-btn>
        </v-row >
        </v-col>
        <v-col align = "center">
          <v-simple-table>
            <thead>
              <tr>
                <th class="text-left">Day/time</th>
                <th class="text-left"> 08.00-09.00 </th>
                <th class="text-left"> 09.00-10.00 </th>
                <th class="text-left"> 10.00-11.00 </th>
                <th class="text-left"> 11.00-12.00 </th>
                <th class="text-left"> 12.00-13.00</th>
                <th class="text-left"> 13.00-14.00 </th>
                <th class="text-left"> 14.00-15.00 </th>
                <th class="text-left"> 15.00-16.00 </th>
              </tr>
            </thead>
            <tbody>
              <tr >
                <tr v-for="item in desserts" :key="item.name">
                <td>{{ item.Day }} </td>
                <td>{{ item.time1 }}</td>
                <td>{{ item.time2 }}</td>
                <td>{{ item.time3 }}</td>
                <td>{{ item.time4 }}</td>
                <td>{{ item.time5 }}</td>
                <td>{{ item.time6 }}</td>
                <td>{{ item.time7 }}</td>
                <td>{{ item.time8 }}</td>
               </tr>
             </tbody>
          </v-simple-table>
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
          employeeId:"",
          roomId:"",
          dayId:"",
          durationId:"",
        },
        
      valid: false,
      employeeCheck: false,
      employeeName: "",
      rooms:[],
      days:[],
      durations:[],
       desserts: [
          {
            Day: 'Monday',
            time1:'',
            time2:'',
            time3:'',
            time4:'',
            time5:'',
            time6:'',
            time7:'',
            time8:'',
          },
          {
           Day: 'Tuseday',
            time1:'',
            time2:'',
            time3:'',
            time4:'',
            time5:'',
            time6:'',
            time7:'',
            time8:'',
          },
 {
           Day: 'Wednesday',
            time1:'',
            time2:'',
            time3:'',
            time4:'',
            time5:'',
            time6:'',
            time7:'',
            time8:'',
          },
           {
           Day: 'Thursday',
            time1:'',
            time2:'',
            time3:'',
            time4:'',
            time5:'',
            time6:'',
            time7:'',
            time8:'',
          },
           {
           Day: 'Friday',
            time1:'',
            time2:'',
            time3:'',
            time4:'',
            time5:'',
            time6:'',
            time7:'',
            time8:'',
          },
         ],  
      
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
    getDuraions() {
      http
        .get("/duration")
        .then(response => {
          this.durations = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
        
    }, findEmployee() {
      http
        .get("/employee/" + this.schedule.employeeId)
        .then(response => {
          console.log(response);
          if (response.data != null) {
            this.employeeName = response.data.name;
            this.employeeCheck = response.status;

          } else {
            this.clear()
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
          "/schedule/" +
            this.schedule.roomId +
            "/" +
            this.schedule.dayId +
            "/" +
            this.schedule.durationId +
            "/" +
            this.schedule.employeeId,
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
      this.employeeCheck = false;
    },
    refreshList() {
      this.getRooms ();
      this.getDays();
      this.getDurations();
      this.findEmployee();
    }

     /* eslint-enable no-console */
    },
    mounted(){
     this.getRooms ();
      this.getDays();
      this.getDurations();
      this.findEmployee();
    }
  
  };
</script>