import React, { useState } from "react";
import axios from "axios";

function AircraftForm() {
  const [form, setForm] = useState({
    model: "",
    registrationNumber: "",
    capacity: "",
    status: "ACTIVE"
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    axios.post("http://localhost:8080/api/aircraft/", form)
      .then(() => {
        alert("Aircraft added!");
        setForm({ model: "", registrationNumber: "", capacity: "", status: "ACTIVE" });
      })
      .catch(err => {
        console.error(err);
        alert("Error adding aircraft");
      });
  };

  return (
    <div>
      <h2>Add Aircraft</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="model"
          placeholder="Model"
          value={form.model}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="registrationNumber"
          placeholder="Registration Number"
          value={form.registrationNumber}
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
        <select
          name="status"
          value={form.status}
          onChange={handleChange}
        >
          <option value="ACTIVE">ACTIVE</option>
          <option value="RETIRED">RETIRED</option>
        </select>
        <button type="submit">Add</button>
      </form>
    </div>
  );
}

export default AircraftForm;
