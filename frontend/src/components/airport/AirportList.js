import React, { useEffect, useState } from "react";
import axios from "axios";

function AirportList() {
  const [airport, setAirport] = useState([]);

  const fetchAirport = () => {
    axios.get("http://localhost:8080/api/airport/")
      .then(res => setAirport(res.data))
      .catch(err => console.error(err));
  };

  useEffect(() => {
    fetchAirport();
  }, []);

  return (
    <div>
      <h2>Airport List</h2>
      <ul>
        {airport.map(a => (
          <li key={a.id}>
            <b>{a.airportId}</b> ({a.airportName}) - {a.city}
          </li>
        ))}
      </ul>
      <button onClick={fetchAirport}>Refresh</button>
    </div>
  );
}

export default AirportList;
