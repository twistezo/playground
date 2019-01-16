using System;

namespace CSharpPlayground
{
    interface IBeing
    {
        void Move();
    }

    interface ISound
    {
        void MakeASound(ref string sound);
    }

    interface IHuman : IBeing, ISound
    {
        void ThinkAboutNumber(int age);
    }

    public class Person : IHuman
    {
        public int age;
        public void Move() => Console.WriteLine("I'm moving!");
        public void ThinkAboutNumber(int number) => Console.WriteLine("Hmm I'm thinking about {0}", number);
        public void MakeASound(ref string sound) => Console.WriteLine(sound);



    }
}
