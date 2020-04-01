function CheckWeight(name, height, weight) {
    this.myName = name;
    this.myHeight = height;
    this.myWeight = weight;
    this.minWeight;
    this.maxWeight;
    }
    CheckWeight.prototype.getInfo = function(){ //체크웨이트라는 오브젝트의 프로토타입으로 정의
        var str = "";
        str += "이름은: " + this.myName + ", ";
        str += "키: " +this.myHeight + ", ";
        str += "몸무게: " + this.myWeight;
        return str;
    }

    CheckWeight.prototype.getResult = function() {
        this.minWeight = (this.myHeight - 100) * 0.9 - 5; //적정범위에서 5정도 뺀 값이 최소적정몸무게
        this.maxWeight = (this.myHeight - 100) * 0.9 + 5; //적정범위에서 5정도 더한 값이 최대적정몸무게
        if (this.myHeight < this.minWeight) {
            return "체중미달";
        }else if (this.myWeight > this.maxWeight){
            return "제충과다";
        }else {
            return "적정체중";
        }
    }



console.log("======f3======")
var person = new CheckWeight("Hong", 170, 65);
var person1 = new CheckWeight("seo", 165, 70);

console.log(person);
console.log(person1);

console.log(person.getInfo());
console.log(person.getResult());


for(f in person){
    // console.log(f, person[f]);
}