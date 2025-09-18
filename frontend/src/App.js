import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

import AircraftList from "./components/aircraft/AircraftList";
import AircraftForm from "./components/aircraft/AircraftForm";
import FlightList from "./components/flight/FlightList";
import FlightForm from "./components/flight/FlightForm";
import AirportList from "./components/airport/AirportList";
import AirportForm from "./components/airport/AirportForm";

function App() {
  return (
    <Router>
      <div style={{ margin: "20px" }}>
        <h1>Management Dashboard</h1>
        <nav>
          <Link to="/aircrafts">Aircrafts</Link> |{" "}
          <Link to="/flights">Flights</Link> |{" "}
          <Link to="/airports">Airports</Link>
        </nav>

        <Routes>
          {/* Default Home Page */}
          <Route path="/" element={<h2>Welcome! Choose a section above.</h2>} />

          <Route
            path="/aircrafts"
            element={
              <>
                <AircraftForm />
                <AircraftList />
              </>
            }
          />

          <Route
            path="/flights"
            element={
              <>
                <FlightForm />
                <FlightList />
              </>
            }
          />

          <Route
            path="/airports"
            element={
              <>
                <AirportForm />
                <AirportList />
              </>
            }
          />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
