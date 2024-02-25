document.addEventListener("DOMContentLoaded", function() {
    const departureCountrySelect = document.getElementById('departureCountry');
    const departureCitySelect = document.getElementById('departureCity');
    const arrivalCountrySelect = document.getElementById('arrivalCountry');
    const arrivalCitySelect = document.getElementById('arrivalCity');
    const returnDateInput = document.getElementById('returnDate');
    const tripTypeRoundTrip = document.getElementById('roundTrip');
    const tripTypeOneWay = document.getElementById('oneWay');

    // Define cities for each country
    const cities = {
        korea: ['인천', '김포', '김해', '제주'],
        japan: ['도쿄', '오사카', '나고야', '후쿠오카', '사가', '코치', '나하'],
        // usa: ['뉴욕', '샌프란시스코', '샌디아고']
        // Add more countries and cities as needed
    };

    // Function to populate city select based on selected country
    function populateDepartureCities() {
        const selectedCountry = departureCountrySelect.value;
        departureCitySelect.innerHTML = '';
        cities[selectedCountry].forEach(city => {
            const option = document.createElement('option');
            option.text = city;
            option.value = city;
            departureCitySelect.appendChild(option);
        });
    }

    function populateArrivalCities() {
        const selectedCountry = arrivalCountrySelect.value;
        arrivalCitySelect.innerHTML = '';
        cities[selectedCountry].forEach(city => {
            const option = document.createElement('option');
            option.text = city;
            option.value = city;
            arrivalCitySelect.appendChild(option);
        });
    }

    // Populate city select when country changes
    departureCountrySelect.addEventListener('change', populateDepartureCities);
    arrivalCountrySelect.addEventListener('change', populateArrivalCities);

    // Initial population of city select
    populateDepartureCities();
    populateArrivalCities();

    // Function to handle trip type change
    function handleTripTypeChange() {
        if (tripTypeRoundTrip.checked) {
            returnDateInput.disabled = false;
        } else if (tripTypeOneWay.checked) {
            returnDateInput.value = '';
            returnDateInput.disabled = true;
        }
    }

    // Add event listeners for trip type change
    tripTypeRoundTrip.addEventListener('change', handleTripTypeChange);
    tripTypeOneWay.addEventListener('change', handleTripTypeChange);



    // const form = document.getElementById('reservationForm');
    // form.addEventListener('submit', function(event) {
    //     event.preventDefault();
    //     const departureCountry = departureCountrySelect.value;
    //     const departureCity = departureCitySelect.value;
    //     const arrivalCountry = arrivalCountrySelect.value;
    //     const arrivalCity = arrivalCitySelect.value;
    //     const departureDate = document.getElementById('departureDate').value;
    //     const returnDate = document.getElementById('returnDate').value;
    //     const budget = document.getElementById('budget').value;
    //     const tripType = document.querySelector('input[name="tripType"]:checked').value;
    //
    //     // 출력
    //     console.log('DepartureCountry:', departureCountry);
    //     console.log('DepartureCity:', departureCity);
    //     console.log('ArrivalCountry:', arrivalCountry);
    //     console.log('ArrivalCity:', arrivalCity);
    //     console.log('Departure Date:', departureDate);
    //     console.log('Return Date:', returnDate);
    //     console.log('Budget:', budget);
    //     console.log('Trip Type:', tripType);
    // });

});