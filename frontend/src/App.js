import React, { useEffect, useState } from "react";
import axios from "axios";

function App() {
  const [aircraft, setAircraft] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/api/aircraft/")
      .then(response => setAircraft(response.data))
      .catch(error => console.error(error));
  }, []);

  return (
    <div>
      <h1>Aircraft List</h1>
      <ul>
        {aircraft.map((a, index) => (
          <li key={index}>{a.name}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
