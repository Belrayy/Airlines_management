import React, { useState } from "react";
import axios from "axios";

function AirportForm() {
  const [form, setForm] = useState({
    airportId: "",
    airportName: "",
    city: ""
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    axios.post("http://localhost:8080/api/airport/", form)
      .then(() => {
        alert("Airport added!");
        setForm({ airportId: "", airportName: "", city: "" });
      })
      .catch(err => {
        console.error(err);
        alert("Error adding airport");
      });
  };

  return (
    <div>
      <h2>Add Airport</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="airportId"
          placeholder="Airport Id"
          value={form.airportId}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="airportName"
          placeholder="Airport Name"
          value={form.airportName}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="city"
          placeholder="City name"
          value={form.city}
          onChange={handleChange}
          required
        />
        <button type="submit">Add</button>
      </form>
    </div>
  );
}

export default AirportForm;
