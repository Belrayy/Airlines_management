import React, { useEffect, useState } from "react";
import axios from "axios";

function AircraftList() {
  const [aircrafts, setAircrafts] = useState([]);

  const fetchAircrafts = () => {
    axios.get("http://localhost:8080/api/aircraft/")
      .then(res => setAircrafts(res.data))
      .catch(err => console.error(err));
  };

  useEffect(() => {
    fetchAircrafts();
  }, []);

  return (
    <div>
      <h2>Aircraft List</h2>
      <ul>
        {aircrafts.map(a => (
          <li key={a.id}>
            <b>{a.model}</b> ({a.registrationNumber}) - {a.capacity} seats - {a.status}
          </li>
        ))}
      </ul>
      <button onClick={fetchAircrafts}>Refresh</button>
    </div>
  );
}

export default AircraftList;
