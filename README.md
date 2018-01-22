# MvpCase


MvpCase clean案列

# Google sample

google sample: https://github.com/googlesamples/android-architecture/tree/todo-mvp-clean/



# Mvp分层

## Base代码：

### P：

```
public abstract class BasePresenter<V extends IBaseView> implements IPresenter<V> {

    private WeakReference<V> viewRef;


    @Override
    public void attachView(V view) {
        viewRef = new WeakReference<V>(view);
    }


    protected V getView() {
        return viewRef == null ? null : viewRef.get();
    }


    protected boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

    @Override
    public void detachView(boolean retainInstance) {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }
}
```

### M:

**DataModel:

```
public abstract class BaseModel<T, E> {

    abstract public T getApi();

    abstract public E getBean(Map maps);
}

```

**ViewModel:

```

public abstract class ModelActivity<V extends IBaseView, P extends IPresenter> extends AppCompatActivity implements IBaseView {

    protected P presenter;
    protected V view;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView(false);
    }

    protected abstract P createPresenter();
}

```


## V:

```

public interface IBaseView<T extends IPresenter> {

    void setPresenter(T presenter);
}

```

