import React, { useEffect, useState } from "react";
import axios from "axios";

function FlightForm() {
  const [form, setForm] = useState({
    flightNumber: "",
    airline: "",
    originId: "",
    destinationId: "",
    departureTime: "",
    arrivalTime: "",
    aircraftId: ""
  });

  const [airports, setAirports] = useState([]);
  const [aircrafts, setAircrafts] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/api/airport/")
      .then(res => setAirports(res.data))
      .catch(err => console.error("Error fetching airports:", err));

    axios.get("http://localhost:8080/api/aircraft/")
      .then(res => setAircrafts(res.data))
      .catch(err => console.error("Error fetching aircrafts:", err));
  }, []);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const payload = {
      flightNumber: form.flightNumber,
      airline: form.airline,
      origin: { id: form.originId },
      destination: { id: form.destinationId },
      departureTime: form.departureTime,
      arrivalTime: form.arrivalTime,
      aircraft: { id: form.aircraftId }
    };

    axios.post("http://localhost:8080/api/flight", payload)
      .then(() => {
        alert("Flight added!");
        setForm({
          flightNumber: "",
          airline: "",
          originId: "",
          destinationId: "",
          departureTime: "",
          arrivalTime: "",
          aircraftId: ""
        });
      })
      .catch(err => {
        console.error("Error adding flight:", err);
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
        <select
          name="originId"
          value={form.originId}
          onChange={handleChange}
          required
        >
          <option value="">Select origin</option>
          {airports.map(a => (
            <option key={a.id} value={a.id}>
              {a.airportName} ({a.city})
            </option>
          ))}
        </select>
        <select
          name="destinationId"
          value={form.destinationId}
          onChange={handleChange}
          required
        >
          <option value="">Select destination</option>
          {airports.map(a => (
            <option key={a.id} value={a.id}>
              {a.airportName} ({a.city})
            </option>
          ))}
        </select>
        <input
          type="datetime-local"
          name="departureTime"
          value={form.departureTime}
          onChange={handleChange}
          required
        />
        <input
          type="datetime-local"
          name="arrivalTime"
          value={form.arrivalTime}
          onChange={handleChange}
          required
        />
        <select
          name="aircraftId"
          value={form.aircraftId}
          onChange={handleChange}
          required
        >
          <option value="">Select aircraft</option>
          {aircrafts.map(ac => (
            <option key={ac.id} value={ac.id}>
              {ac.model} ({ac.registrationNumber})
            </option>
          ))}
        </select>
        <button type="submit">Add Flight</button>
      </form>
    </div>
  );
}

export default FlightForm;
