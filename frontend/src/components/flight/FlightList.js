import React, { useEffect, useState } from "react";
import axios from "axios";

function FlightList() {
  const [flight, setFlight] = useState([]);

  const fetchFlight = () => {
    axios.get("http://localhost:8080/api/flight")
      .then(res => setFlight(res.data))
      .catch(err => console.error(err));
  };

  useEffect(() => {
    fetchFlight();
  }, []);

  return (
    <div>
      <h2>Flights List</h2>
      <ul>
        {flight.map(f => (
          <li key={f.id}>
            <b>{f.flightNumber}</b> ({f.airline}) - {f.origin} - {f.destination} - {f.departureTime} - {f.arrivalTime} - {f.capacity} seats
          </li>
        ))}
      </ul>
      <button onClick={fetchFlight}>Refresh</button>
    </div>
  );
}

export default FlightList;