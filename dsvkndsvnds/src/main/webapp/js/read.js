fetch('read',
    {
        method:'POST',
        headers:{
            'Content-Type':'application/json'
    }}).then(response => response.json()).then(data=>{
        const tbl = document.querySelector('#table');
        const tr = document.createElement('tr')
        const tdName = document.createElement('td')
        const tdYear = document.createElement('td')
        const tdlch = document.createElement('td')
        const tdchamp = document.createElement('td')
        const tdcountry = document.createElement('td')

        tdName.textContent="name"
        tdYear.textContent="year"
        tdlch.textContent="lch"
        tdchamp.textContent="champ"
        tdcountry.textContent="country"

        tr.appendChild(tdName)
        tr.appendChild(tdYear)
        tr.appendChild(tdlch)
        tr.appendChild(tdchamp)
        tr.appendChild(tdcountry)
        tbl.appendChild(tr)
        data.forEach(team=>{
            console.log(team)
            const trCont=document.createElement('tr');
            const tdNameCont = document.createElement('td')
            const tdYearCont = document.createElement('td')
            const tdlchCont = document.createElement('td')
            const tdchampCont = document.createElement('td')
            const tdcountryCont = document.createElement('td')

            tdNameCont.textContent=team.name
            tdYearCont.textContent=team.year
            tdlchCont.textContent=team.lch
            tdchampCont.textContent=team.champ
            tdcountryCont.textContent=team.country

            trCont.appendChild(tdNameCont)
            trCont.appendChild(tdYearCont)
            trCont.appendChild(tdlchCont)
            trCont.appendChild(tdchampCont)
            trCont.appendChild(tdcountryCont)
            tbl.appendChild(trCont)
       })
})