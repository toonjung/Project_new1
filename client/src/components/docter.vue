<template>
  <v-form v-model="valid">
    <v-container>
      <v-row>
           <!--search -->
             <v-col cols="12" md="3" >
               <v-row>
                  <v-text-field 
                    v-model="schedule.employeeId" 
                    :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']" 
                    label="ชื่อแพทย์" 
                    required > 
                  </v-text-field>
                   <!--ปุ่ม search -->
                  <v-btn class="ma-6" small color="primary" dark @click="findemployees" > Search</v-btn> 
                  <p v-if="employeeCheck != ''">ID แพทย์ : {{employeeName}}</p>             
               </v-row>
            <!--End search -->   
            <!-- combobox-->   
              <v-row>
                  <!-- end combobox room-->
                  <v-select 
                    v-model="schedule.roomId" 
                    :items="rooms" 
                    item-text="room" 
                    item-value="id"  
                    label="โปรดเลือกห้องตรวจ" >
                    :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']"
                    required
                 </v-select>
                  <!-- end combobox room-->
                  <!-- combobox day-->  
                  <v-select 
                    v-model="schedule.dayId" 
                    :items="days"  
                    item-text="day" 
                    item-value="id"
                    label="โปรดเลือกวัน">
                    :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']"
                    required
                  </v-select>
                  <!-- end combobox room-->
                  <!-- combobox room--> 
                  <v-select 
                    v-model="schedule.timeId" 
                    :items="times"  
                    item-text="time" 
                    item-value="id"
                    label="โปรดเลือกเวลา" >
                    :rules="[(v) => !!v || 'กรุณากรอกข้อมูล']"
                    required
                    </v-select> 
                    <!-- end combobox room-->
                 </v-row>   
                  <!-- combobox-->  
                   <!-- ปุ่ม-->  
              <v-row justify="center">  
                 <v-btn 
                 @click="add"
                  class="mr-4" 
                  color="primary">ADD</v-btn>
                <v-btn 
                   @click="remove"
                   class="mr-4"
                color="error">REMOVE</v-btn>     
              </v-row >  
                <!--end ปุ่ม-->  
                  <!-- ตารางแสดงข้อมูล --> 
             </v-col> 
               <v-col cols="12" md="9"  >
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
                                     <tr v-for="item in desserts" :key="item.name">
                                            <td>{{ item.Day }}</td>
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
  </v-form>
</template>

<script>

import http from "../http-common"
  export default {
 name: "schedule",
  data() {
    return {
      schedule: {
        dayId: "",
        employeeId: "",
        roomId: "",
        timeId: "",
        
      },
      
      valid: false,
      employeeCheck: false,
      employeeName: [],
      roomTitle:[],
      dayTitle:[],
      timeTitle:[],
      employees:[],
      days:[],
      times:[],
      rooms:[],
      
    };
  },
    ///////////////////////////////////////////////////////////////////
     methods: {
       /* eslint-disable no-console */
   //1 ปุ่ม search 
    findEmployee() {
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
   // end search 

      //2 ดึงข้อมูล Employee ใส่ combobox
    getEmployees() {
      http
        .get("/employee")
        .then(response => {
          this.employees = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล Employee ใส่ combobox

    //3 ดึงข้อมูล Room ใส่ combobox
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
    // ดึงข้อมูล Room ใส่ combobox
    //3 ดึงข้อมูล Day ใส่ combobox
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
    // ดึงข้อมูล Day ใส่ combobox
    //3 ดึงข้อมูล Time ใส่ combobox
    getTimes() {
      http
        .get("/time")
        .then(response => {
          this.times = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    // ดึงข้อมูล Day ใส่ combobox
    findEmployees() {
      http
        .get("/employee/" + this.schedule.employeeId)
        .then(response => {
          console.log(response);
        if(response.data != null){
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
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // function เมื่อกดปุ่ม submit
    add() {
      
      http
        .post(
          "/schedule/" +
          this.schedule.employeeId + 
          "/" + 
          this.schedule.roomId + 
          "/" +
          this.schedule.dayId +
          "/" + 
          this.schedule.timeId ,
          this.schedule 
        )
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
    this.getEmployees();
    this.getRooms();
    this.getDays();
    this.getTimes();
    this.findEmployees();
  
    }
     /* eslint-enable no-console */
    //ที่เรียกมาใช้
     },
    mounted() {
    this.getEmployees();
    this.getRooms();
    this.getDays();
    this.getTimes();
    this.findEmployees();
   
  
  }
  };
</script>