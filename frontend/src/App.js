import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import { AppBar, Toolbar, Button, Box, Typography, Container, Paper, Stack } from "@mui/material";

import AircraftList from "./components/aircraft/AircraftList";
import AircraftForm from "./components/aircraft/AircraftForm";
import FlightList from "./components/flight/FlightList";
import FlightForm from "./components/flight/FlightForm";
import AirportList from "./components/airport/AirportList";
import AirportForm from "./components/airport/AirportForm";

// function App() {
//   return (
//     <Router>
//       <div style={{ margin: "20px" }}>
//         <h1>Management Dashboard</h1>
//         <nav>
//           <Link to="/aircrafts">Aircrafts</Link> |{" "}
//           <Link to="/flights">Flights</Link> |{" "}
//           <Link to="/airports">Airports</Link>
//         </nav>

//         <Routes>
//           {/* Default Home Page */}
//           <Route path="/" element={<h2>Welcome! Choose a section above.</h2>} />

//           <Route
//             path="/aircrafts"
//             element={
//               <>
//                 <AircraftForm />
//                 <AircraftList />
//               </>
//             }
//           />

//           <Route
//             path="/flights"
//             element={
//               <>
//                 <FlightForm />
//                 <FlightList />
//               </>
//             }
//           />

//           <Route
//             path="/airports"
//             element={
//               <>
//                 <AirportForm />
//                 <AirportList />
//               </>
//             }
//           />
//         </Routes>
//       </div>
//     </Router>
//   );
// }


function App() {
  return (
    <Router>
      <AppBar position="static">
        <Toolbar>
          <Typography variant="h6" sx={{ flexGrow: 1 }}>
            ✈️ Management Dashboard
          </Typography>
          <Button color="inherit" component={Link} to="/aircraft">Aircrafts</Button>
          <Button color="inherit" component={Link} to="/flight">Flights</Button>
          <Button color="inherit" component={Link} to="/airport">Airports</Button>
        </Toolbar>
      </AppBar>

      <Container sx={{ mt: 4 }}>
        <Routes>
          <Route
            path="/"
            element={
              <Box display="flex" justifyContent="center" alignItems="center" minHeight="100vh">
                <Typography variant="h5">Welcome! Choose a section above.</Typography>
              </Box>
            }
          />
          <Route
            path="/aircraft"
            element={
              <Stack spacing={3}>
                <Paper sx={{ p: 3 }}>
                  <Typography variant="h6">Add Aircraft</Typography>
                  <AircraftForm />
                </Paper>
                <Paper sx={{ p: 3 }}>
                  <Typography variant="h6">Aircrafts List</Typography>
                  <AircraftList />
                </Paper>
              </Stack>
            }
          />
          <Route
            path="/flight"
            element={
              <Stack spacing={3}>
                <Paper sx={{ p: 3 }}>
                  <Typography variant="h6">Add Flight</Typography>
                  <FlightForm />
                </Paper>
                <Paper sx={{ p: 3 }}>
                  <Typography variant="h6">Flights List</Typography>
                  <FlightList />
                </Paper>
              </Stack>
            }
          />
          <Route
            path="/airport"
            element={
              <Stack spacing={3}>
                <Paper sx={{ p: 3 }}>
                  <Typography variant="h6">Add Airport</Typography>
                  <AirportForm />
                </Paper>
                <Paper sx={{ p: 3 }}>
                  <Typography variant="h6">Airports List</Typography>
                  <AirportList />
                </Paper>
              </Stack>
            }
          />
        </Routes>
      </Container>
    </Router>
  );
}


export default App;
