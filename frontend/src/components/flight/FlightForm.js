import React, { useState } from "react";
import axios from "axios";

function FlightForm() {
  const [form, setForm] = useState({
    flightNumber: "",
    airline: "",
    origin: "",
    destination: "",
    departureTime: "",
    arrivalTime: "",
    capacity: ""
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    axios.post("http://localhost:8080/api/flight", form)
      .then(() => {
        alert("Flight added!");
        setForm({ flightNumber: "", airline: "", origin: "", destination: "", departureTime: "", arrivalTime: "", capacity: "" });
      })
      .catch(err => {
        console.error(err);
        alert("Error adding flight");
      });
  };

  return (
    <div>
      <h2>Add Flight</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="flightNumber"
          placeholder="Flight Number"
          value={form.flightNumber}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="airline"
          placeholder="Airline"
          value={form.airline}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="origin"
          placeholder="Origin"
          value={form.origin}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="destination"
          placeholder="Destination"
          value={form.airline}
          onChange={handleChange}
          required
        />
        <input
          type="datetime-local"
          name="departureTime"
          placeholder="Departure Time"
          value={form.departureTime}
          onChange={handleChange}
          required
        />
        <input
          type="datetime-local"
          name="arrivalTime"
          placeholder="Arrival Time"
          value={form.arrivalTime}
          onChange={handleChange}
          required
        />
        <input
          type="number"
          min={1}
          name="capacity"
          placeholder="Capacity"
          value={form.capacity}
          onChange={handleChange}
          required
        />
        <button type="submit">Add</button>
      </form>
    </div>
  );
}

export default FlightForm;
