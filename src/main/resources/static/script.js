function init(){
    setInterval(function () {
        const u = new XMLHttpRequest();
        u.open("GET", "/get");
        u.send(null);
        u.onreadystatechange = function () {
            if(u.response.length > 20) {
                const arr = JSON.parse(u.response);
                const lst = document.getElementById("lst");
                while (lst.childNodes.length > 0) {
                    lst.removeChild(lst.childNodes[0]);
                }
                //lst.innerHTML = '<img src="/logo.png" alt="Logo">';
                for (let i = 9; i >= 0; i--) {
                    let nc = document.createElement('p');
                    nc.textContent = arr[i];
                    lst.appendChild(nc)
                }
                let bad = ['Обнаружено нарушение. Вызван наряд полиции.',
                    'Мусорные контейнеры переполнены. Вызван мусоровоз.'];
                if(arr[9] in bad){
                    document.getElementById('container').classList.remove('good');
                    document.getElementById('container').classList.add('bad');
                }else{
                    document.getElementById('container').classList.remove('bad');
                    document.getElementById('container').classList.add('good');
                }
            }
        }
    }, 1000);
}
