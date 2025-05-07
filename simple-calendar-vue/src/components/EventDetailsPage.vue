<template>
  <div><h1>Event Details</h1>
  <h2>Oпис події: {{ event.description }}</h2>
  <h2>Локація: {{ event.location }}</h2>
  <h2>Дата початку: {{ event.startDate }}</h2>
  <h2>Дата закінчення: {{ event.endDate }}</h2>
  </div>
  
</template>

<script lang="ts" setup>
import { defineProps } from "vue";
import { useRoute } from 'vue-router'
import { onMounted, ref } from 'vue';
import axios from 'axios';

const route = useRoute()
const props = defineProps({id: Number})

const event = ref(Event);

const fetchEvent = async () => {
  try {
    const response = await axios.get('http://localhost:8080/event/' + route.params.id);
    event.value = response.data;
    console.log(event.value)
    let startDate = new Date(event.value.startDate).toISOString().split('T')[0]
    let startTime = new Date(event.value.startDate).toISOString().split('T')[1].slice(0,5)
    event.value.startDate = startDate + " " + startTime
    let endDate = new Date(event.value.endDate).toISOString().split('T')[0]
    let endTime = new Date(event.value.endDate).toISOString().split('T')[1].slice(0,5)
    event.value.endDate = endDate + " " + endTime
  } catch (error) {
    console.error('Error while fetching event:', error);
  }
};

onMounted(fetchEvent);
</script> 