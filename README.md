# Flight Management System

## Overview
The Flight Management System is a Java-based application designed to manage flights, crew members, and pricing dynamically. It leverages data structures such as AVL trees and directed weighted graphs for efficient data organization and operations. The system includes a user-friendly command-line interface (CLI) to manage and visualize flights and their crew members.

## Features
- **Flight Management**:
  - Add new flights with details such as origin, destination, base price, and capacity.
  - View all flights and their connections.
  - Dynamically calculate flight prices based on occupancy.

- **Crew Management**:
  - Add crew members to specific flights.
  - View crew members organized in an AVL tree.
  - Observe AVL tree balancing in real time.

- **Test Data Loader**:
  - Load predefined flights and crew members for testing purposes.

## Technologies Used
- **Java**: Core programming language.
- **Data Structures**:
  - **AVL Tree**: Used for managing crew members, ensuring efficient insertion and retrieval.
  - **Directed Weighted Graph**: Represents flights and their connections.
- **CLI (Command-Line Interface)**: Provides an interactive menu-driven experience.

## Getting Started

### Prerequisites
- **Java JDK**: Ensure you have Java 8 or later installed.
- **IDE or Terminal**: Use an IDE like IntelliJ IDEA, Eclipse, or a terminal with a text editor.

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/ThiagoLopezA/flight-management-system.git
   ```
2. Navigate to the project directory:
   ```bash
   cd flight-management-system
   ```
3. Compile the project:
   ```bash
   javac src/**/*.java
   ```
4. Run the application:
   ```bash
   java src/App
   ```

## Usage

### Main Menu
1. **Manage Flights**: Navigate to the Flight Menu to add or view flights.
2. **Load Test Data**: Preload flights and crew members to quickly test the system.
3. **Exit**: Close the application.

### Flight Menu
- **Add Flight**: Input origin, destination, base price, and capacity to create a flight.
- **Select Flight for Crew Management**: Manage crew members for a selected flight.
- **Print All Flights**: View all flights in the graph representation.

### Crew Menu
- **Print Crew Members**: Displays crew members in a tree graph format.
- **Add Crew Member**: Add new crew members with names and seat numbers to a flight.

## Data Structures

### AVL Tree
- Balances crew members based on their seat numbers.
- Ensures efficient insertion, deletion, and traversal.
- Visualizes the tree structure dynamically.

### Directed Weighted Graph
- Represents flights as vertices and their connections as edges.
- Edge weights represent flight costs.

## Example Outputs

### Flight Graph:
```
Graph Representation:
Cordoba -> { Buenos Aires (Cost: 80000), Bariloche (Cost: 120000) }
Buenos Aires -> { Bariloche (Cost: 150000), Cordoba (Cost: 100000) }
Bariloche -> { Cordoba (Cost: 100000) }
```

### Crew Tree:
```
Crew Members (Tree Graph):
└── CrewMember{name='Grace', seatNumber=7}
    ├── CrewMember{name='Charlie', seatNumber=3}
    │   ├── CrewMember{name='Alice', seatNumber=1}
    │   └── CrewMember{name='Bob', seatNumber=2}
    └── CrewMember{name='Frank', seatNumber=6}
        ├── CrewMember{name='Diana', seatNumber=4}
        └── CrewMember{name='Eve', seatNumber=5}
```

## Authors
- Thiago Lopez
- Francisco Melaragno

## License
This project is licensed under the MIT License. See the LICENSE file for details.

