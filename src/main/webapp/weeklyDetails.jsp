<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%
    Map<String, Long> m = (Map<String, Long>) session.getAttribute("weekly");
    // Prepare JSON-like strings for JavaScript
    StringBuilder labels = new StringBuilder("[");
    StringBuilder dataValues = new StringBuilder("[");

    if (m != null && !m.isEmpty()) {
        for (Map.Entry<String, Long> entry : m.entrySet()) {
            if (labels.length() > 1) {
                labels.append(",");
                dataValues.append(",");
            }
            labels.append("\"").append(entry.getKey()).append("\"");
            dataValues.append((float)entry.getValue()/3600);
        }
        labels.append("]");
        dataValues.append("]");
    }
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css\index.css">

    <meta charset="UTF-8">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
    	input{
    		height:60px;
    	}
        .chart-container {
            width: 100%; /* Adjust to fit your layout */
            max-width: 600px; /* Adjust as needed */
            margin: 0 auto; /* Center the container */
            padding: 20px; /* Add padding if needed */
        }
        #workDurationChart {
            width: 100%; /* Ensure the chart fits its container */
            height: 400px; /* Adjust height */
        }
    </style>
    <title>Weekly Details</title>
</head>
<body>
<div class="area" >
<div class="context">
<center>
    <form action="weekly" method="post">
        <table>
            <tr>
                <td><input name="username" placeholder="Enter username"></td>
                <td><button type="submit">Check</button></td>
            </tr>
        </table>
    </form>

    <% if (m != null && !m.isEmpty()) { %>
        <div class="chart-container">
            <canvas id="workDurationChart"></canvas>
        </div>
        <script>
            const ctx = document.getElementById('workDurationChart').getContext('2d');

            // Convert server-side data to JavaScript
            const labels = <%= labels.toString() %>;
            const dataValues = <%= dataValues.toString() %>;

            const data = {
                labels: labels,
                datasets: [{
                    label: 'Work Duration (hours)',
                    data: dataValues,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.4)',
                        'rgba(54, 162, 235, 0.4)',
                        'rgba(255, 206, 86, 0.4)',
                        'rgba(75, 192, 192, 0.4)',
                        'rgba(153, 102, 255, 0.4)',
                        'rgba(255, 159, 64, 0.4)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
            };

            const config = {
                type: 'pie',
                data: data,
                options: {
                    responsive: true,
                    maintainAspectRatio: false, // Allows resizing without keeping aspect ratio
                    plugins: {
                        legend: {
                            position: 'top', // Position the legend
                        },
                        tooltip: {
                            callbacks: {
                                label: function(tooltipItem) {
                                    return tooltipItem.label + ': ' + tooltipItem.raw + ' hours';
                                }
                            }
                        }
                    }
                }
            };

            // Render the chart
            new Chart(ctx, config);
        </script>
    <% } %>
</center>
</div>

            <ul class="circles">
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
            </ul>
    </div >

</body>
</html>
