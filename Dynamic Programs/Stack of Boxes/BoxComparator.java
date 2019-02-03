import java.util.Comparator;

class BoxComparator implements Comparator<Box>
{
    @Override
    public int compare(Box a, Box b)
    {
        return b.height - a.height;
    }
}