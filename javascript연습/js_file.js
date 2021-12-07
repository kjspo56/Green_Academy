console.log("Hello JavaScript");

var healthobj = {
    name : "달리기",
    lastTime : "PM 10:12",
    showHealth() {
        console.log(this.name + "님, 오늘은" + this.lastTime + "에 운동을 하시네요");
    }
}

healthojb.showHealth();
