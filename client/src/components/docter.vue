<template>
  <v-form v-model="valid">
    <v-container>
      <v-row>
        
             <v-col cols="12" md="3" >
               <v-row>
                  <v-text-field v-model="Doctername" :rules="nameRules" label="ชื่อแพทย์" required > </v-text-field>
                <v-btn class="ma-6" small color="primary" dark > Search</v-btn>              
               </v-row>
                  
              <v-row>
                  <v-select v-model="select"  :items="items"   label="โปรดเลือกห้องตรวจ" ></v-select>
                  <v-select v-model="select2" :items="items2"  label="โปรดเลือกวัน"   ></v-select>
                  <v-select v-model="select3" :items="items3"  label="โปรดเลือกเวลา" ></v-select> 
                 </v-row>   
              <v-row justify="center">  
                 <v-btn class="mr-4" color="primary">ADD</v-btn>
                <v-btn color="error">REMOVE</v-btn>     
              </v-row >   
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
  export default {
    data () {
      return {
        select: 'ห้องตรวจ',
        items: [
          'ห้องตรวจ 1',
          'ห้องตรวจ 2',
          'ห้องตรวจ 3',
          'ห้องตรวจ 4',
          'ห้องตรวจ 5',

        ],
        select2: 'เลือกวัน',
        items2: [
          'Monday',
          'Thuseday',
          'Wednesday',
          'Thursday',
          'Friday',

        ],
        select3: 'เลือกเวลา',
        items3: [
          '08.00-09.00',
          '09.00-10.00 ',
          '10.00-11.00',
          '11.00-12.00',
          '12.00-13.00',
          '13.00-14.00',
          '14.00-15.00',
          '15.00-16.00',
         


        ],
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
      }
    },
  }
</script>