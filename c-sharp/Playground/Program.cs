using System;

namespace CSharpPlayground
{
    class Program
    {
        private static Person john;
        static void Main(string[] args)
        {
            john = new Person
            {
                age = 20
            };
            john.Move();
            string sound = "I'm screaming!";
            john.MakeASound(ref sound);
            john.ThinkAboutNumber(18);
        }
    }

    class TypesAndVariables
    {
        enum MachineState

        {
            PowerOff = 0,
            Running = 1,
        }

        void goGoGoEnum()
        {
            byte machineState = (byte)MachineState.PowerOff;
        }

        void goGoGoVariables()
        {
            sbyte
            signedByte; // 8 bits
            short signedShort; // 16 bits
            int signedInt; // 32 bits
            long signedLong; // 64 bits

            byte unsignedByte;
            ushort unsignedShort;
            uint unsignedInt;
            ulong unsignedLong;

            float floatVar = 1.1f; // 32 bits
            double doubleVar = 1.1d; // 64 bits
            decimal decimalVar = 1212.0m; /// 128 bits
        }

        void goGoGoTypes()
        {
            object something = "John";
            something = null;

        }
    }
}