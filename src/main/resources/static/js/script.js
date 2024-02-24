document.addEventListener("DOMContentLoaded", function() {
    const countrySelect = document.getElementById('country');
    const citySelect = document.getElementById('city');
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
    function populateCities() {
        const selectedCountry = countrySelect.value;
        citySelect.innerHTML = '';
        cities[selectedCountry].forEach(city => {
            const option = document.createElement('option');
            option.text = city;
            option.value = city;
            citySelect.appendChild(option);
        });
    }

    // Populate city select when country changes
    countrySelect.addEventListener('change', populateCities);

    // Initial population of city select
    populateCities();

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



    const form = document.getElementById('reservationForm');
    form.addEventListener('submit', function(event) {
        event.preventDefault();
        const country = countrySelect.value;
        const city = citySelect.value;
        const departureDate = document.getElementById('departureDate').value;
        const returnDate = document.getElementById('returnDate').value;
        const budget = document.getElementById('budget').value;
        const tripType = document.querySelector('input[name="tripType"]:checked').value;

        // 출력
        console.log('Country:', country);
        console.log('City:', city);
        console.log('Departure Date:', departureDate);
        console.log('Return Date:', returnDate);
        console.log('Budget:', budget);
        console.log('Trip Type:', tripType);
    });

});




// // 시/도(select id = sido) 요소와 시/군구(select id = sigg) 요소 가져오기
// const countrySelect = document.getElementById('country');
// const citySelect = document.getElementById('city');
//
//
// // 시/도 선택 상자가 변경될 때 실행할 함수를 정의
// countrySelect.addEventListener('change', function () {
//     const selectedCountry = countrySelect.value;
//
//     // 시/도를 선택하지 않은 경우 시/군구 선택 상자를 비활성화하고 초기화
//     if (!selectedCountry) {
//         citySelect.innerHTML = '<option value="" disabled selected>상세지역</option>';
//         citySelect.disabled = true;
//
//     } else {
//         // 시/도를 선택한 경우, AJAX 요청으로 서버에서 해당 시/도에 속하는 시/군구 목록을 가져오기
//         fetch(`/get_sigg_list/?sido=${selectedCountry}`)
//             .then(response => response.json())
//             .then(data => {
//                 citySelect.innerHTML = '<option value="" disabled selected>도시</option>';
//
//                 // 서버에서 받은 데이터로 시/군구 선택 상자를 업데이트
//                 data.forEach(sigg => {
//                     citySelect.innerHTML += `<option value="${sigg.name}">${sigg.name}</option>`;
//                 });
//
//                 // 시/군구 선택 상자를 활성화
//                 citySelect.disabled = false;
//
//                 // default값 설정
//                 // siggSelect.selectedIndex = 1;
//                 selected_city.value = citySelect.options[1].value;
//             });
//     }
// });
//
// // document.addEventListener('DOMContentLoaded', function () {
// //     siggSelect.innerHTML = '<option value="" disabled selected>도시</option>';
// //     siggSelect.disabled = true;
// // });
//
//