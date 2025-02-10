let employees = [];

async function fetchEmployees() {
    try {
        const response = await fetch('http://localhost:9092/api/employees');
        employees = await response.json();
        updateEmployeeTable();
    } catch (error) {
        console.error('Error fetching employees:', error);
    }
}

function updateEmployeeTable() {
    const tableBody = document.getElementById('employeesListBody');
    tableBody.innerHTML = ''; // Clear the table before updating

    employees.forEach(emp => {
        const row = `<tr>
            <td>${emp.name}</td>
            <td>${emp.department}</td>
            <td>${emp.email}</td>
            <td>${emp.position}</td>
        </tr>`;
        tableBody.innerHTML += row;
    });
}

document.getElementById('employeeForm').addEventListener('submit', async (e) => {
    e.preventDefault();
    
    const newEmployee = {
        name: document.getElementById('name').value,
        department: parseInt(document.getElementById('department').value),
        email: document.getElementById('email').value,
        position: document.getElementById('position').value
    };

    try {
        const response = await fetch('http://localhost:9092/api/employees', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(newEmployee)
        });
        
        if (response.ok) {
            await fetchEmployees(); // Refresh table with new data
            e.target.reset();
        }
    } catch (error) {
        console.error('Error adding employee:', error);
    }
});

// Fetch employees on page load
window.onload = fetchEmployees;
