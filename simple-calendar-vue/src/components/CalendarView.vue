<template>
    <div class="flex">
        <router-link to="/add-event">
        <button class="add-event-button">
            Add Event
        </button>
        </router-link>
    <div><h1>Calendar</h1></div>
    </div>
    <a-calendar v-model:value="value">
    <template #dateCellRender="{ current }">
      <ul class="events">
        <li v-for="item in getListData(current)" :key="item.id" @click="goToEvent(item.id)">
            <a-badge :text="item.title" />
        </li>
      </ul>
    </template>
    <template #monthCellRender="{ current }">
      <div v-if="getMonthData(current)" class="notes-month">
        <section>{{ getMonthData(current) }}</section>
        <span>Backlog number</span>
      </div>
    </template>
  </a-calendar>
  </template>

<script lang="ts" setup>
import { onMounted, ref } from 'vue';
import { Dayjs } from 'dayjs';
import router from '@/router';
import axios from 'axios';
const value = ref<Dayjs>();

const events = ref([]);

const fetchEvents = async () => {
  try {
    const response = await axios.get('http://localhost:8080/events');
    events.value = response.data;
  } catch (error) {
    console.error('Error while fetching events:', error);
  }
};

onMounted(fetchEvents);

const getListData = (value: Dayjs) => {
  const dateStr = value.format('YYYY-MM-DD');

  const listData = events.value.filter((event: any) => {
    const eventDate = new Date(event.startDate).toISOString().split('T')[0];
    return eventDate === dateStr;
  });
  return listData || [];
};

const getMonthData = (value: Dayjs) => {
  if (value.month() === 8) {
    return 1394;
  }

  return {
      value,
      getListData,
      getMonthData,
    };
};

const goToEvent = (id: string) => {
    router.push({ name: 'event-details', params: { id: id } })
}


</script>

<style scoped>
.events {
  list-style: none;
  margin: 0;
  padding: 0;
}
.events .ant-badge-status {
  overflow: hidden;
  white-space: nowrap;
  width: 100%;
  text-overflow: ellipsis;
  font-size: 12px;
}
.notes-month {
  text-align: center;
  font-size: 28px;
}
.notes-month section {
  font-size: 28px;
}

a :hover{
    cursor: pointer;
}
 
a {
    height: fit-content;
}

.add-event-button {
    background-color: skyblue;
    border-color: transparent;
    padding: 8px;
    color: white;
    font-weight: 900;
    font-size: 18px;
    margin-top: 15px;
    border-radius: 10%;
}

.flex {
    display: flex;
    justify-content: space-between;
    width: 500px;
    align-content: flex-start;
    margin-left: 300px;
}
</style>
